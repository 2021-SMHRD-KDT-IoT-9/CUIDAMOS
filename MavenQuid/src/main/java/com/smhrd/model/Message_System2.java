package com.smhrd.model;

import java.util.*;
import java.io.*;
import java.net.*;

public class Message_System2 {
	public static void main(String[] args) throws IOException {

		String furniture = "a0001";
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.connection(furniture);
		
		String gu_id = dto.getGU_ID();
		String gu_name = dto.getGU_NAME();
		String address = dto.getAddress();
		String phone = dto.getPHONE();
		

		String url = "https://directsend.co.kr/index.php/api_v2/sms_change_word"; // URL

		java.net.URL obj;
		obj = new java.net.URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestProperty("Cache-Control", "no-cache");
		con.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		con.setRequestProperty("Accept", "application/json");

		/*
		 * title : MMS/LMS 발송시에 사용하는 제목 (최대 40byte) message : 받을 문자 내용 (최대 2000byte), 치환
		 * 문자열 사용 가능. 치환 문자열 : [$NAME] - 이름 (한글 10글자/영문 30byte 처리), [$MOBILE] - 휴대폰,
		 * [$NOTE1] - 비고1 (한글/영문 128자 처리), [$NOTE2] - 비고2 (한글/영문 128자 처리), [$NOTE3] -
		 * 비고3 (한글/영문 128자 처리), [$NOTE4] - 비고4 (한글/영문 128자 처리), [$NOTE5] - 비고5 (한글/영문
		 * 128자 처리) username : directsend 발급 ID receiver : 발송 할 고객 수신자 정보 json array.
		 * ex) [ {"name": "강길동", "mobile":"", "note1":"", "note2":"", "note3":"",
		 * "note4":"", "note5":""} , {"name": "홍길동", "mobile":"수신자번호",
		 * "note1":"다이렉트센드 2", "note2":"다이렉트센드 3", "note3":"다이렉트센드 4",
		 * "note4":"다이렉트센드 5", "note5":"다이렉트센드 6"} ] address_books : 사이트에 등록한 발송 할 주소록
		 * 번호 , 로 구분함 (ex. 0,1,2) duplicate_yn : 수신자 정보가 중복될 경우 중복발송을 할지에 대한 여부 key :
		 * directsend 발급 api key returnURL : 실제 발송결과를 return 받을 URL 번호 attaches : 첨부파일의
		 * URL(영문) (jpg, jpeg 파일만 3개까지 가능, 파일당 300kb 제한)
		 *
		 * 각 번호가 유효하지 않을 경우에는 발송이 되지 않습니다. 비고 내용이 최대 길이(한글/영문 128자 처리)를 넘는 경우 최대 길이 만큼
		 * 잘려서 치환 됩니다. 전기통신사업법 84조에 의거 사전 등록 된 발송번호가 없다면 문자를 발송할 수 없습니다.
		 *
		 * 야간 시간대(오후 9시 ~ 다음날 8시)에 영리 목적의 광고성 정보를 전송하고자 하는 경우, 영리 목적의 광고성 정보 수신에 대한 일반적
		 * 사전 동의 외에 별도의 동의를 받지 않았을 경우 3천 만원 이하의 과태료가 부과됩니다. 야간 시간대 또는 주말, 연휴 기간에는 문자 인증이
		 * 다소 지연될 될 수 있으니 양해 부탁드립니다. (광고)문자를 발송시 문자내용앞에 (광고)표시, 하단에 080무료수신거부를 미 기재 후 발송
		 * 시, 발송 서비스 이용 제약 및 정보통신망법에 의한 처벌(벌금 3,000만원) 대상입니다. 불법 스팸 문자 발송 시 예고없이 서비스 이용이
		 * 정지될 수 있으며 이용정지 시 해당 아이디의 주소록과 잔액은 소멸되며, 환불되지 않으니 서비스 이용에 주의를 부탁드립니다. 이동통신사의
		 * 스팸규제 강화에 따라 스팸차단 서비스가 적용되어 정상 메시지도 스팸으로 분류되어 스팸문자로 보관함에 수신되고 수신자에게 전송 안 된 경우
		 * 실제 발송은 성공으로 금액이 차감되는 점 유의 바랍니다.
		 *
		 * API 연동 발송시 다량의 주소를 한번에 입력하여도 수신자에게는 1:1로 보내는 것으로 표기되며, 동일한 내용의 문자를 한건씩 발송하는
		 * 것보다 다량으로 한번에 보내는 것이 발송 효율이 더 높습니다. 동일한 내용의 문자를 일부 글자만 변경하여 다수에게 발송하시는 경우 수신자
		 * 정보를 Json Array [{...}, {...}]로 구분하시어 한번에 발송하시는 것을 권장 드립니다.
		 */

		/* 여기서부터 수정해주시기 바랍니다. */

		String title = "희경이바보";
		String message = address + "로 가주세요"; // 필수입력
		String sender = "01064246895"; // 필수입력
		String username = "ndn153"; // 필수입력
		String key = "ycmTnGo5CgI2P1J"; // 필수입력

		// 수신자 정보 추가 - 필수 입력(주소록 미사용시), 치환문자 미사용시 치환문자 데이터를 입력하지 않고 사용할수 있습니다.
		// 치환문자 미사용시 {\"mobile\":\"01000000001\"} 번호만 입력 해주시기 바랍니다.
		String receiver = "{\"name\": \"" + gu_name + "\", \"mobile\":\"" + phone + "\", \"note1\":\"\", \"note2\":\"\", \"note3\":\"\", \"note4\":\"\", \"note5\":\"\"}"
				+ ",{\"name\": \"홍길동\", \"mobile\":\"수신자번호\", \"note1\":\"다이렉트센드 2\", \"note2\":\"다이렉트센드 3\", \"note3\":\"다이렉트센드 4\", \"note4\":\"다이렉트센드 5\", \"note5\":\"다이렉트센드 6\"}";

		receiver = "[" + receiver + "]";

		// 주소록을 사용하길 원하실 경우 아래 주석을 해제하신 후, 사이트에 등록한 주소록 번호를 입력해주시기 바랍니다.
		// String address_books = "0,1,2" //사이트에 등록한 발송 할 주소록 번호 , 로 구분함 (ex. 0,1,2)

		// 수신자 정보가 중복이고 내용이 다를 경우 아래 주석을 해제하시고 발송해주시기 바랍니다.
		// String duplicate_yn = "1";

		// 예약발송 정보 추가
		String sms_type = "NORMAL"; // NORMAL - 즉시발송 / ONETIME - 1회예약 / WEEKLY - 매주정기예약 / MONTHLY - 매월정기예약
		String start_reserve_time = "2019-03-08 12:11:00";// 발송하고자 하는 시간
		String end_reserve_time = "2019-03-08 12:11:00";// 발송이 끝나는 시간 1회 예약일 경우 start_reserve_time = end_reserve_time
		// WEEKLY | MONTHLY 일 경우에 시작 시간부터 끝나는 시간까지 발송되는 횟수 Ex) type = WEEKLY,
		// start_reserve_time = '2017-05-17 13:00:00', end_reserve_time = '2017-05-24
		// 13:00:00' 이면 remained_count = 2 로 되어야 합니다.
		int remained_count = 1;
		// 예약 수정/취소 API는 소스 하단을 참고 해주시기 바랍니다.

		// 실제 발송성공실패 여부를 받기 원하실 경우 아래 주석을 해제하신 후, 사이트에 등록한 URL 번호를 입력해 주시기 바랍니다.
		// int returnURL = 0;

		// 첨부파일이 있을 시 아래 주석을 해제하고 첨부하실 파일의 URL을 배열로 입력하여 주시기 바랍니다.
		// jpg파일당 300kb 제한 3개까지 가능합니다.
		// String attaches =
		// "https://directsend.co.kr/jpgimg1.jpg,https://directsend.co.kr/jpgimg2.jpg,https://directsend.co.kr/jpgimg3.jpg";

		/* 여기까지만 수정해주시기 바랍니다. */

		String urlParameters = "\"title\":\"" + title + "\" " + ", \"message\":\"" + message + "\" " + ", \"sender\":\""
				+ sender + "\" " + ", \"username\":\"" + username + "\" " + ", \"receiver\":" + receiver
				// + ", \"address_books\":\"" + address_books + "\" " //주소록 사용할 경우 주석 해제
				// + ", \"duplicate_yn\":\"" + duplicate_yn + "\" " //중복 발송을 허용할 경우 주석 해제

				// 예약 관련 파라미터 주석 해제
				// + ", \"sms_type\":\"" + sms_type + "\" "
				// + ", \"start_reserve_time\":\"" + start_reserve_time + "\" "
				// + ", \"end_reserve_time\":\"" + end_reserve_time + "\" "
				// + ", \"remained_count\":\"" + remained_count + "\" "

				// + ", \"return_url_yn\": " + true //returnURL이 있는 경우 주석해제 바랍니다.(필수입력)
				// + ", \"return_url\":\"" + returnURL + "\" " // returnURL이 있는 경우 주석해제 바랍니다.
				+ ", \"key\":\"" + key + "\" " + ", \"type\":\"" + "java" + "\" ";
		// + ", \"attaches\":\"" + attaches + "\" "; // 첨부파일이 있는 경우 주석해제 바랍니다.
		urlParameters = "{" + urlParameters + "}"; // JSON 데이터

		System.setProperty("jsse.enableSNIExtension", "false");
		con.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
		wr.write(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println(responseCode);

		/*
		 * responseCode 가 200 이 아니면 내부에서 문제가 발생한 케이스입니다. directsend 관리자에게 문의해주시기 바랍니다.
		 */

		java.io.BufferedReader in = new java.io.BufferedReader(
				new java.io.InputStreamReader(con.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}

		in.close();

		System.out.println(response.toString());

		/*
		 * response의 실패 {"status":113, "msg":"UTF-8 인코딩이 아닙니다."} 실패 코드번호, 내용
		 *
		 * status code 112 실패인 경우 인코딩 실패 문자열 return {"status":112, "msg":
		 * "message EUC-KR 인코딩에 실패 하였습니다.", "msg_detail":풰(13)} 실패 코드번호, 내용, 인코딩 실패
		 * 문자열(문자열 위치)
		 */

		/*
		 * response 성공 {"status":0} 성공 코드번호 (성공코드는 다이렉트센드 DB서버에 정상수신됨을 뜻하며 발송성공(실패)의 결과는
		 * 발송완료 이후 확인 가능합니다.)
		 *
		 * 잘못된 번호가 포함된 경우 {"status":0, "msg":"유효하지 않는 번호를 제외하고 발송 완료 하였습니다.",
		 * "msg_detail":"error mobile : 01000000001aa, 010112"} 성공 코드번호 (성공코드는 다이렉트센드
		 * DB서버에 정상수신됨을 뜻하며 발송성공(실패)의 결과는 발송완료 이후 확인 가능합니다.), 내용, 잘못된 데이터
		 *
		 */

		/*
		 * status code 0 : 정상발송 (성공코드는 다이렉트센드 DB서버에 정상수신됨을 뜻하며 발송성공(실패)의 결과는 발송완료 이후 확인
		 * 가능합니다.) 100 : POST validation 실패 101 : sender 유효한 번호가 아님 102 : recipient 유효한
		 * 번호가 아님 103 : 회원정보가 일치하지 않음 104 : 받는 사람이 없습니다 105 : message length = 0,
		 * message length >= 2000, title >= 20 106 : message validation 실패 107 : 이미지 업로드
		 * 실패 108 : 이미지 갯수 초과 109 : return_url이 유효하지 않습니다 110 : 이미지 용량 300kb 초과 111 :
		 * 이미지 확장자 오류 112 : euckr 인코딩 에러 발생 114 : 예약정보가 유효하지 않습니다. 200 : 동일 예약시간으로는 200회
		 * 이상 API 호출을 할 수 없습니다. 201 : 분당 300회 이상 API 호출을 할 수 없습니다. 205 : 잔액부족 999 :
		 * Internal Error.
		 */

		/*
		 * ====================================== 예약 목록 API 시작
		 * ======================================
		 */
		/*
		 * 예약 목록 조회 API username : directsend 발급 ID key : directsend 발급 api key
		 *
		 * 예약목록 조회 -> 예약 번호 확인 -> 예약 수정/예약 취소 -> 예약 목록 조회(수정정보 확인) 예약번호, 문자번호등 예약정보를
		 * 조회하기 위한 API 입니다. 예약 목록을 조회하여 JSON 형식으로 전달 됩니다. JSON형식 POST값으로 전달 해야 됩니다. 예약
		 * 목록 API 사용시 주석 해제후 사용 하시기 바랍니다.
		 */

		/* 여기서부터 수정해주시기 바랍니다. */

		// String username = "DirectSend id"; //필수입력
		// String key = "DirectSend 발급 api key"; //필수입력

		/* 여기까지 수정해주시기 바랍니다. */

		// String postvars = "{\"username\":\""+ username +"\",\"key\":\""+ key +"\"}";
		// //JSON 데이터

		// String url = "https://directsend.co.kr/index.php/api_sms_reserve/get"; //URL

		// java.net.URL obj;
		// obj = new java.net.URL(url);
		// HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// con.setRequestProperty("Cache-Control", "no-cache");
		// con.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		// con.setRequestProperty("Accept", "application/json");

		// System.setProperty("jsse.enableSNIExtension", "false");
		// con.setDoOutput(true);
		// OutputStreamWriter wr = new OutputStreamWriter (con.getOutputStream(),
		// "UTF-8");
		// wr.write(postvars);
		// wr.flush();
		// wr.close();

		// int responseCode = con.getResponseCode();
		// System.out.println(responseCode);

		/*
		 * responseCode 가 200 이 아니면 내부에서 문제가 발생한 케이스입니다. directsend 관리자에게 문의해주시기 바랍니다.
		 */

		// java.io.BufferedReader in = new java.io.BufferedReader(
		// new java.io.InputStreamReader(con.getInputStream(), "UTF-8"));
		// String inputLine;
		// StringBuffer response = new StringBuffer();

		// while ((inputLine = in.readLine()) != null) {
		// response.append(inputLine);
		// }

		// in.close();

		// System.out.println(response.toString());

		/*
		 * response 성공 json 데이터 양식 {result:1, message:"success", data:{~~}}
		 * data:total_count 예약 목록 전체 갯수 data:list[~~] 예약 목록 정보 번호 sms_reserve_no 발송총횟수
		 * sms_reserve_count 등록일 sms_reserve_date 발송시작일 sms_reserve_startdate 발송종료일
		 * sms_reserve_enddate 예약유형 sms_reserve_type 1 : 1회 / 2 : 매주 / 3 : 매달 발송 총 건수
		 * sms_send_count 발송자 번호 sms_send_number 문자 본문 sms_send_body 인증여부
		 * sms_reserve_auth_flag 0 : 비인증 / 1 : 인증 문자 번호 sms_no MMS 이미지 mms_images 바이트 수
		 * byte
		 */

		/*
		 * response 실패 json 데이터 양식 {result:200-1, message:에러 내용}
		 */

		/*
		 * status code 1 : 성공 200-1 : 파라미터 오류 200-2 : 예약 목록 조회 오류
		 */
		/*
		 * ====================================== 예약 목록 API 끝
		 * ======================================
		 */

		/*
		 * ====================================== 예약 번호별 정보 조회 API 시작
		 * ======================================
		 */
		/*
		 * 예약 번호별 정보 조회 API username : directsend 발급 ID key : directsend 발급 api key
		 * reserve_no : directsend 예약 번호
		 *
		 * 예약번호별 예약정보를 조회하기 위한 API 입니다. 예약 정보를 조회하여 JSON 형식으로 전달 됩니다. JSON형식 POST값으로 전달
		 * 해야 됩니다. 예약 번호별 정보 조회 API 사용시 주석 해제후 사용 하시기 바랍니다.
		 */

		/* 여기서부터 수정해주시기 바랍니다. */

		// String username = "DirectSend id"; //필수입력
		// String key = "DirectSend 발급 api key"; //필수입력
		// String reserve_no = "DirectSend 예약번호"; //필수입력

		/* 여기까지 수정해주시기 바랍니다. */

		// String postvars = "{\"username\":\""+ username +"\",\"key\":\""+ key
		// +"\",\"reserve_no\":\""+ reserve_no +"\"}"; //JSON 데이터

		// String url = "https://directsend.co.kr/index.php/api_sms_reserve/get"; //URL

		// java.net.URL obj;
		// obj = new java.net.URL(url);
		// HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// con.setRequestProperty("Cache-Control", "no-cache");
		// con.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		// con.setRequestProperty("Accept", "application/json");

		// System.setProperty("jsse.enableSNIExtension", "false");
		// con.setDoOutput(true);
		// OutputStreamWriter wr = new OutputStreamWriter (con.getOutputStream(),
		// "UTF-8");
		// wr.write(postvars);
		// wr.flush();
		// wr.close();

		// int responseCode = con.getResponseCode();
		// System.out.println(responseCode);

		/*
		 * responseCode 가 200 이 아니면 내부에서 문제가 발생한 케이스입니다. directsend 관리자에게 문의해주시기 바랍니다.
		 */

		// java.io.BufferedReader in = new java.io.BufferedReader(
		// new java.io.InputStreamReader(con.getInputStream(), "UTF-8"));
		// String inputLine;
		// StringBuffer response = new StringBuffer();

		// while ((inputLine = in.readLine()) != null) {
		// response.append(inputLine);
		// }

		// in.close();

		// System.out.println(response.toString());

		/*
		 * response 성공 json 데이터 양식 {result:1, message:"success", data:{~~}}
		 * data:list[~~] 예약 정보 번호 sms_reserve_no 발송총횟수 sms_reserve_count 등록일
		 * sms_reserve_date 발송시작일 sms_reserve_startdate 발송종료일 sms_reserve_enddate 예약유형
		 * sms_reserve_type 1 : 1회 / 2 : 매주 / 3 : 매달 발송 총 건수 sms_send_count 발송자 번호
		 * sms_send_number 문자 본문 sms_send_body 인증여부 sms_reserve_auth_flag 0 : 비인증 / 1 :
		 * 인증 문자 번호 sms_no MMS 이미지 mms_images 바이트 수 byte
		 */

		/*
		 * response 실패 json 데이터 양식 {result:200-1, message:에러 내용}
		 */

		/*
		 * status code 1 : 성공 200-1 : 파라미터 오류 200-2 : 예약 정보 조회 오류
		 */
		/*
		 * ====================================== 예약 번호별 정보 조회 API 끝
		 * ======================================
		 */

		/*
		 * ====================================== 예약 수정/취소 API 시작
		 * ======================================
		 */
		/*
		 * 예약 수정/취소 API username : directsend 발급 ID key : directsend 발급 api key
		 * reserve_no : directsend 예약 번호 sms_no : directsend 문자 번호 reserve_type : 예약 유형,
		 * 예약 수정 API 사용시 필수 입력 sms_reserve_startdate : 발송하고자 하는 시간(시,분단위까지만 가능), 예약 수정
		 * API 사용시 필수 입력 sms_reserve_enddate : 발송이 끝나는 시간, 예약 수정 API 사용시 필수 입력
		 *
		 * 예약 수정/취소 API에서 사용 하는 예약번호, 문자번호는 예약 목록 API를 통하여 확인하실 수 있습니다. 예약 목록을 조회하여 예약
		 * 수정/취소 정보를 JSON 형식으로 전달 해야 됩니다. JSON형식 POST값으로 전달 해야 됩니다. 예약 API 사용시 주석 해제후 사용
		 * 하시기 바랍니다.
		 */

		/* 여기서부터 수정해주시기 바랍니다. */

		// String username = "DirectSend id"; //필수입력
		// String key = "DirectSend 발급 api key"; //필수입력
		// String reserve_no = "DirectSend 예약번호"; //예약 번호 (예약목록 조회 API를 사용하여 확인), 필수입력
		// String sms_no = "DirectSend 문자 번호"; //뮨자 번호 (예약목록 조회 API를 사용하여 확인), 필수입력

		// 예약 수정 API 사용시 주석해제
		// String reserve_type = "1"; //필수입력 1 : 1회 / 2 : 매주 / 3 : 매달
		// String sms_reserve_startdate = "2019-05-11 12:11:00";// 발송하고자 하는 시간
		// String sms_reserve_enddate = "2019-05-11 12:11:00";// 발송이 끝나는 시간 1회 예약일 경우
		// sms_reserve_startdate = sms_reserve_enddate

		/* 여기까지 수정해주시기 바랍니다. */

		// String postvars = "\"username\":\""+ username + "\""
		// +",\"key\":\""+ key +"\""
		// +",\"reserve_no\":\""+ reserve_no +"\""
		// +",\"sms_no\":\""+ sms_no +"\""
		// +",\"reserve_type\":\""+ reserve_type +"\""
		// +",\"sms_reserve_startdate\":\""+ sms_reserve_startdate +"\""
		// +",\"sms_reserve_enddate\":\""+ sms_reserve_enddate +"\""
		// ;
		// postvars = "{"+ postvars +"}";

		// String url = "";

		// 예약 수정 API 사용시 주석 해제
		// url = "https://directsend.co.kr/index.php/api_sms_reserve/put"; //URL

		// 예약 취소 API 사용시 주석 해제
		// url = "https://directsend.co.kr/index.php/api_sms_reserve/delete"; //URL

		// java.net.URL obj;
		// obj = new java.net.URL(url);
		// HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// con.setRequestProperty("Cache-Control", "no-cache");
		// con.setRequestProperty("Content-Type", "application/json;charset=utf-8");
		// con.setRequestProperty("Accept", "application/json");

		// System.setProperty("jsse.enableSNIExtension", "false");
		// con.setDoOutput(true);
		// OutputStreamWriter wr = new OutputStreamWriter (con.getOutputStream(),
		// "UTF-8");
		// wr.write(postvars);
		// wr.flush();
		// wr.close();

		// int responseCode = con.getResponseCode();
		// System.out.println(responseCode);

		/*
		 * responseCode 가 200 이 아니면 내부에서 문제가 발생한 케이스입니다. directsend 관리자에게 문의해주시기 바랍니다.
		 */

		// java.io.BufferedReader in = new java.io.BufferedReader(
		// new java.io.InputStreamReader(con.getInputStream(), "UTF-8"));
		// String inputLine;
		// StringBuffer response = new StringBuffer();

		// while ((inputLine = in.readLine()) != null) {
		// response.append(inputLine);
		// }

		// in.close();

		// System.out.println(response.toString());

		/*
		 * response 성공 json 데이터 양식 {result:1, message:success}
		 */

		/*
		 * response 실패 json 데이터 양식 {result:200-1, message:에러 내용}
		 */

		/*
		 * status code 1 : 성공 200-3 : 예약 정보 오류 200-4 : 예약 수정 처리 오류 200-5 : 예약 취소 처리 오류
		 */
		/*
		 * ====================================== 예약 수정/취소 API 끝
		 * ======================================
		 */
	}
}