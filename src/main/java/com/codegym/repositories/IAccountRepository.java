package com.codegym.repositories;

import com.codegym.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "select * from account join employee on account.accountId=employee.accountId where account.accountId=?1", nativeQuery = true)
    Account findAccountById(Integer AccountId);

    //    edit password by Nhật
    @Modifying
    @Query(value = "update account set account_password = ?2 where (account_id = ?1);", nativeQuery = true)
    void editPassword(Integer id, String password);

    // Xem thông tin user by Nhật
    @Query(value = "select *" +
            "from account a " +
            " where a.account_id =?1", nativeQuery = true)
    Account getAccountById(@Param("id") Integer id);

    // NhatDV getAccountByName
    @Query(value = "select a.account_id,a.account_username,a.account_password,a.active_flag,a.delete_flag,a.email \n" +
            "from account a \n" +
            "where a.account_username= ?1", nativeQuery = true)
    Account getAccountByName(@Param("name") String name);
}
