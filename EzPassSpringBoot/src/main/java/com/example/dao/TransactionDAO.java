package com.example.dao;

import com.example.model.Transaction;
import java.util.List;

public interface TransactionDAO {
    public String recordTransaction(Transaction transaction);
    public List<Transaction> getAllTransactions(String CustomerID);
    public List<Transaction> getTransactions(String CustomerID, String before, String after);
}
