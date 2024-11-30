package bridge.model;

import java.util.List;

public class User {

    List<String> userRoute;
    List<String> upRoute;
    List<String> downRoute;

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
