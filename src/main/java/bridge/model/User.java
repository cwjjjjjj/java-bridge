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

    public void addUpRoute(String Route) {
        upRoute.add(Route);
    }

    public void addDownRoute(String Route) {
        downRoute.add(Route);
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
