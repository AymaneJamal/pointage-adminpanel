package com.Pointage.adminPanel.AuthController;

import com.Pointage.adminPanel.model.RevokedToken;
import com.Pointage.adminPanel.repository.RevokedTokenRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogoutService {

    private final RevokedTokenRepository revokedTokenRepository;

    public LogoutService(RevokedTokenRepository revokedTokenRepository) {
        this.revokedTokenRepository = revokedTokenRepository;
    }

    public void logout(String token) {
        RevokedToken revokedToken = new RevokedToken();
        revokedToken.setToken(token);
        revokedToken.setRevokedAt(new Date());
        revokedTokenRepository.save(revokedToken);
    }
}