package at.technikum.mvvm.service;

import at.technikum.mvvm.dto.Route;

public interface RouteService {

    Route getRoute(String from, String to);

    void saveMap(String sessionId, String filename);
}
