package JavaSE07_3;

import java.util.Random;

@SuppressWarnings("WeakerAccess")
class IntegerSetterGetter extends Thread {

    private final SharedResource resource;
    private boolean run;
    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        synchronized (resource) {
            run = false;
            resource.notifyAll();
        }
    }

    public void run() {
        int action;
        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток" + getName() + "завершил работу");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number = null;
        synchronized (resource) {
            System.out.println("Поток" + getName() + "хочет извлечь число.");
            while (run && (number = resource.getElement()) == null)  {
                System.out.println("Поток" + getName() + "ждет пока очередь заполнится.");
                resource.wait();
                System.out.println("Поток" + getName() + "возобновил работу.");
            }
            if (number != null)
                System.out.println("Поток" + getName() + "извлек число" + number);
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {

        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток" + getName() + "записал число" + number);
            resource.notify();
        }
    }
}