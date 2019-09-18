package cn.itcast.listener;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {
		Timer timer = new Timer();
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 3, 15, 15, 27, 00);
		/*
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				System.out.println("执行了");
			}
		}, cal.getTime());*/
		timer.schedule(new TimerTask(){

			public void run() {
				System.out.println("我来了");
			}
		}, 5*1000, 1000);
	}

}
