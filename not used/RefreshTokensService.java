package qinetic.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;

@Service
@Transactional
public class RefreshTokensService {

    @Autowired
    private qinetic.repository.RefreshTokensDAO refreshTokensDAO;

    public void setRefreshTokensDAO(qinetic.repository.RefreshTokensDAO refreshTokensDAO) {
        this.refreshTokensDAO = refreshTokensDAO;
    }

    @Transactional
    public void addRefreshToken(qinetic.model.RefreshTokens refreshTokens) {
        this.refreshTokensDAO.addRefreshToken(refreshTokens);
    }
}