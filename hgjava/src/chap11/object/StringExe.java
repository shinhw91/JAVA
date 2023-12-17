package chap11.object;

public class StringExe {

	public static void main(String[] args) {
		String[] fileNames = { "c:/images/prod/sample.jpg", "d:/test/sample/americado.png",
				"d:/goods/test/2023/moka.jpg" };
		for (String file : fileNames) {
			System.out.println(findFileName2(file));
		}

		String[] numbers = { "980304-1234567", "980304-2234567", "020101-3456789", "020104-4456789", "0301053545678" };
		for (String no : numbers) {
			System.out.println(findGender2(no));
		}

		byte[] b1 = "Hello".getBytes();
		for (byte b : b1) {
			System.out.println(b);
		}

		String name = new String(new byte[] { 65, 66, 67, 68, 69 });
		name = new String(b1);

		System.out.println(name);

		char c1 = name.charAt(0);
		System.out.println(c1);

	} // end main

	// 성별을 반환
	static String findGender(String ssn) {
		// 생년월일 : 남(1, 3), 여(2, 4)
		char gender = ssn.charAt(7);
		char gender2 = ssn.charAt(6);

		if (ssn.length() == 14) {
			if (gender == '1' || gender == '3') {
				return "남";
			} else {
				return "여";
			}
		} else if (ssn.length() == 13) {
			if (gender2 == '1' || gender2 == '3') {
				return "남";
			} else {
				return "여";
			}
		} else {
			return "값이 유효하지 않습니다";
		}

	} // end findGender

	static String findGender2(String ssn) {
		int pos = ssn.length() - 7;
		switch (ssn.charAt(pos)) {
		case '1':
		case '3':
			return "남";
		case '2':
		case '4':
			return "여";
		}
		return "오류";
	} // end findGender2

	// 파일명을 가져오기
	static String findFileName(String file) {
		int slash = 0;
		for (int i = 0; i < file.length(); i++) {
			slash = file.lastIndexOf("/");
		}

		int dot = file.indexOf(".");

		return file.substring(slash + 1, dot);
	}
	
	static String findFileName2(String file) {
		int pos = 0;
		while(true) {
			int pos2 = file.indexOf("/", pos);
			if(pos2 == -1) {
				break;
			}
			pos2++;
			pos = pos2;
		}
		return file.substring(pos);
	}


} // end class
