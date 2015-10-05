package com.qaiware.llamakisses.repository;

import org.springframework.dao.DataAccessException;
import com.qaiware.llamakisses.model.User;


public interface UserRepository {

    /**
     * Retrieve an <code>User</code> from the data store by id.
     *
     * @param id the id to search for
     * @return the <code>User</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException
     *          if not found
     */
    User findById(int id) throws DataAccessException;
}
