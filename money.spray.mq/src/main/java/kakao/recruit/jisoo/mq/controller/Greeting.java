package kakao.recruit.jisoo.mq.controller;

public class Greeting {
	private final String roomId;
	private final String content;

	public Greeting(String roomId, String content) {
		this.roomId = roomId;
		this.content = content;
	}

	public String getRoomId() {
		return roomId;
	}

	public String getContent() {
		return content;
	}
}
