package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String> userRoute;
    private List<String> upRoute;
    private List<String> downRoute;

    public User() {
        userRoute = new ArrayList<>();
        upRoute = new ArrayList<>();
        downRoute = new ArrayList<>();
    }

    public void addUpRoute(String upRoute) {
        userRoute.add(upRoute);
    }

    public void addDownRoute(String downRoute) {
        userRoute.add(downRoute);
    }

    public void addUserRoute(String route) {
        userRoute.add(route);
    }

    public List<String> getUserRoute() {
        return userRoute;
    }

    public List<String> getUpRoute() {
        return upRoute;
    }

    public List<String> getDownRoute() {
        return downRoute;
    }
}
