package edu.yu.oats.oatsdb.dbms;

/** The TxStatus enum defines the set of transaction status codes.
 *
 * Design note: API loosely modeled on javax.transaction APIs
 * https://docs.oracle.com/javaee/5/api/javax/transaction/package-summary.html
 * 
 * @author Avraham Leff
 */

public enum TxStatus {
  UNKNOWN, ACTIVE, COMMITTED, COMMITTING, ROLLEDBACK, ROLLING_BACK, NO_TRANSACTION
}
