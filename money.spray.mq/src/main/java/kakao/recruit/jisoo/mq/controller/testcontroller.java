package kakao.recruit.jisoo.mq.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kakao.recruit.jisoo.mq.ReceiveConsumer;
import kakao.recruit.jisoo.mq.SprayProducer;
import kakao.recruit.jisoo.mq.dto.Spray;
import kakao.recruit.jisoo.mq.dto.SprayHistory;
import kakao.recruit.jisoo.mq.error.ReceiveException;
import kakao.recruit.jisoo.mq.error.SearchEmptyException;
import kakao.recruit.jisoo.mq.error.SprayException;
import kakao.recruit.jisoo.mq.repo.SprayHistoryRepository;
import kakao.recruit.jisoo.mq.svc.JwtService;

@RestController
public class testcontroller {
	
	@Autowired
    private JwtService jwtService;

	@Autowired 
	private SprayHistoryRepository shRepository;
	
	@GetMapping("/spray")
	public Greeting spray(
			@RequestHeader HttpHeaders headers,
			@RequestParam(value="price", required=true) String price,
			@RequestParam(value="cnt", required=true) int cnt) {
		
		
		int sPrice = Integer.parseInt(price);
		int chk = 0;
		String sRoomId = headers.get("X-ROOM-ID").get(0);
		String sUserId = headers.get("X-USER-ID").get(0);
		
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < cnt; i++) {
			int sNprice = (sPrice/2);
			SprayHistory sh = new SprayHistory(sPrice, sNprice, sUserId, "", "N", startTime);
			sh = shRepository.save(sh);
			
			Spray sSpray = new Spray(sh.getId(),sNprice,sUserId,startTime);
			
			String dToken = jwtService.create(sRoomId,sSpray,sUserId);
			sPrice = sNprice/2;
			
			if(new SprayProducer().run(sRoomId,dToken));
				chk++;
		}
		if(chk == cnt)
			return new Greeting(sRoomId, "뿌리기 성공");
		else
			throw new SprayException();
		
	}
	
	@GetMapping("/receiver")
	public Map<String, Object> receiver(
			@RequestHeader HttpHeaders headers) {
		String sRoomId = headers.get("X-ROOM-ID").get(0);
		String sUserId = headers.get("X-USER-ID").get(0);
		
		String rToken = new ReceiveConsumer().run(sRoomId);
		
		if (rToken.isEmpty())
			throw new ReceiveException();
		
		Map<String, Object> rData = jwtService.get(sRoomId,rToken);
		shRepository.update(Integer.parseInt(rData.get("id").toString()),sUserId);
		return rData;
	}
	
	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<SprayHistory> getAllUsers(@RequestHeader HttpHeaders headers) {
	    // This returns a JSON or XML with the users
		/*
		 * SprayHistory sh = new SprayHistory(); sh.setId(1); sh.setR_price(100);
		 * shRepository.save(sh);
		 */
		  String sUserId = headers.get("X-USER-ID").get(0);
			/* System.out.println(shRepository.select(sUserId)); */
		  List<SprayHistory> sSpHistory = shRepository.select(sUserId);
		  
		  if(sSpHistory.size() == 0)
			  throw new SearchEmptyException();
		  
	    return shRepository.select(sUserId);
	  }
	
}