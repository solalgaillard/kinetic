package qinetic.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.*;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RefreshTokensDAO extends CrudRepository<qinetic.model.RefreshTokens, Long> {

}