package client.gui.listener;

public class RefreshListener extends Thread {

    private ICallbackFunction callbackFunction;
    private int milisecond;
    private boolean isTerminate;

    public RefreshListener(ICallbackFunction callbackFunction, int milisecond) {
        this.callbackFunction = callbackFunction;
        this.milisecond = milisecond;
        isTerminate = false;
    }

    public void ternimate() {
        isTerminate = true;
    }

    @Override
    public void run() {
        while (!isTerminate){
            callbackFunction.process();

            try {
                Thread.sleep(milisecond);
            } catch (InterruptedException e) {
            }
        }
    }
}
