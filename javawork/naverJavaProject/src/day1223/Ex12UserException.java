package day1223;

class UserException extends Exception {
	public UserException(String message) {
		super(message);
	}
}

public class Ex12UserException {

	public static void inputName(String name) throws UserException {
		if (name.equals("김태희") || name.equals("송혜교"))
			throw new UserException("구라치지 마라."); // Exception 강제 발생
		else
			System.out.println("이름: " + name);
	}

	public static void main(String[] args) {
		try {
			inputName("성시경");
		} catch (UserException e) {
			System.out.println("오류 메시지: " + e.getMessage());
		}

		try {
			inputName("송혜교");
		} catch (UserException e) {
			System.out.println("오류 메시지: " + e.getMessage());
		}

		System.out.println("정상 종료");
	}

}
