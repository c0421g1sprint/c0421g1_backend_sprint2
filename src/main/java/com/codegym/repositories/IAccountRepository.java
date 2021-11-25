package com.codegym.repositories;
import com.codegym.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account,Integer> {


//    PhucNK
    @Query(value="select * from account join employee on account.accountId=employee.accountId where account.accountId=?1",nativeQuery = true)
    Account findAccountById(Integer AccountId);

//PhucNK
    @Query(value="select * from account  where account.account_username=?1",nativeQuery = true)
    Account findAccountByUserName(String accountName);


}
