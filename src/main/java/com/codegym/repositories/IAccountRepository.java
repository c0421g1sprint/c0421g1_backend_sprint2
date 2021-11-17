package com.codegym.repositories;

import com.codegym.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account,Integer> {
//    edit password by Nhật
    @Modifying
    @Query(value = "update account set account_password = ?2 where (account_id = ?1);", nativeQuery = true)
    void editPassword(Integer id ,String password);
// Xem thông tin user by Nhật
    @Query(value = "select *" +
            "from account a " +
            " where a.account_id =?1",nativeQuery = true)
    Account getAccountById(@Param("id") Integer id);
}
