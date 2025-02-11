package src.model;

public class TimerThread extends Thread {
    private int seconds;
    private boolean isRunning = true;

    public TimerThread(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        while (isRunning && seconds > 0) {
            try {
                if(seconds%5 == 0){
                    System.out.print("\r남은 시간: " + seconds + "초 "); // \r로 한 줄로 업데이트
                }
                Thread.sleep(1000); // 1초에 한번씩 내림
                seconds--;
            } catch (InterruptedException e) {
                System.out.println("\n입력 완료! 카운트다운 종료.");
                return; // 스레드 종료
            }
        }
        if(isRunning){
            System.out.println("\n시간 초과! 프로그램을 종료합니다.");
        }
        System.exit(0);
    }

    public void stopTimer(){
        this.isRunning = false;
    }
}
