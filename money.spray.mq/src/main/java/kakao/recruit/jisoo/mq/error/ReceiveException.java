package kakao.recruit.jisoo.mq.error;

public class ReceiveException  extends RuntimeException{
	private static final long serialVersionUID = -2238030302650813813L;
	
	public ReceiveException() {
		super("받기 실패.");
	}
	
}
