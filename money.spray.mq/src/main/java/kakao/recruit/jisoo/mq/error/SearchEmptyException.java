package kakao.recruit.jisoo.mq.error;

public class SearchEmptyException extends RuntimeException{
	private static final long serialVersionUID = -2238030302650813813L;
	
	public SearchEmptyException() {
		super("조회 실패.");
	}
	
}