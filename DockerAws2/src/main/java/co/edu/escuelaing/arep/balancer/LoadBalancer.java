package co.edu.escuelaing.arep.balancer;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {

    private static final LoadBalancer INSTANCE = new LoadBalancer();

    private static List<String> ports;

    private static int currentIndex;

    private LoadBalancer(){
        ports = new ArrayList<>();
        currentIndex = 0;
        ports.add("http://172.31.58.84:42000");
        ports.add("http://172.31.58.84:42001");
        ports.add("http://172.31.58.84:42002");
    }

    public static LoadBalancer getInstance(){
        return INSTANCE;
    }



    public static String getPort(){
        synchronized(ports) {
            if (currentIndex >= ports.size()) {
                currentIndex = 0;
            }

            String port = ports.get(currentIndex);
            currentIndex++;

            return port;
        }
    }
}
