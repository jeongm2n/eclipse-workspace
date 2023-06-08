package chap19;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------");
		System.out.println("서버를 종료하려면 q또는 Q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("-----------------------------------------------");
		
		startServer(); //TCP 서버 시작
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			String key = sc.nextLine();
			if(key.toLowerCase().equals("q")) break;
		}
		
		sc.close();
		
		stopServer(); //TCP서버 종료 
	}
	
	public static void startServer() { //작업 스레드 정의 
		Thread thread = new Thread() {
			public void run() {
				try {
					//서버소켓 생성 및 포트 바인딩 
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");
					
					while(true) {
						System.out.println("\n[서버] 연결 요청 기다림");
						
						Socket socket = serverSocket.accept();
						
						//연결된 클라이언트 정보 얻기 
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버] " + isa.getHostName() + "의 연결 요청을 수락함");
						
						socket.close();
						System.out.println("[서버] " + isa.getHostName() + "의 연결을 끊음");
					}
				}catch(IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		
		thread.start();
	}
	
	public static void stopServer() {
		try {
			//서버 소켓을 닫고 포트 언바인딩 
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		}catch(IOException e1) {}
	}

}
