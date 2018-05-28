package edu.yu.oats.oatsdb.dbms;

/** Enum defining the valid set of OATSdb versions.
 *
 * @author Avraham Leff
 */

import java.lang.reflect.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum OATSDBType {
  V0, V0b, V0c, V1a;


  /** Use reflection to create appropriate instance of DBMS
   *
   * @param OATSDB_Type enum value specifies the DBMS instance you want
   * @throws InstantiationException
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static DBMS dbmsFactory(OATSDBType oatsdbType)
  throws InstantiationException
  {
    logger.info("Creating DBMS implementation for {}", oatsdbType);

    DBMS dbms = null;

    try {
      if (oatsdbType == null) {
        final String msg = "Null 'oatsdbType' parameter";
        logger.error(msg);
        throw new ClassNotFoundException(msg);
      }

      Class<?> clazz = null;
      Object instance = null;

      switch(oatsdbType) {
      case V0:
        clazz = Class.forName("edu.yu.oats.oatsdb.dbms.v0.DBMSImpl");
        instance = Enum.valueOf((Class<Enum>)clazz, "Instance");
        dbms = DBMS.class.cast(instance);
        break;
      case V0b:
        clazz = Class.forName("edu.yu.oats.oatsdb.dbms.v0b.DBMSImpl");
        instance = Enum.valueOf((Class<Enum>)clazz, "Instance");
        dbms = DBMS.class.cast(instance);
        break;
      case V0c:
        clazz = Class.forName("edu.yu.oats.oatsdb.dbms.v0c.DBMSImpl");
        instance = Enum.valueOf((Class<Enum>)clazz, "Instance");
        dbms = DBMS.class.cast(instance);
        break;
      case V1a:
        clazz = Class.forName("edu.yu.oats.oatsdb.dbms.v1a.DBMSImpl");
        instance = Enum.valueOf((Class<Enum>)clazz, "Instance");
        dbms = DBMS.class.cast(instance);
        break;
      default:
        logger.error("Unknown 'oatsdbType' parameter: {}", oatsdbType);
        throw new ClassNotFoundException
          ("Unknown 'oatsdbType' parameter: "+oatsdbType);
      } // switch
    }   // try
    catch(Exception e) {
      final String msg = "Problem creating instance of "+oatsdbType+" ["+e+"]";
      logger.error(msg);
      throw new InstantiationException(msg); // no version which takes "cause"
    }

    return dbms;
  }

  /** Use reflection to create appropriate instance of TxMgr
   *
   * @param OATSDB_Type enum value specifies the TxMgr instance you want
   * @throws InstantiationException
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static TxMgr txMgrFactory(OATSDBType oatsdbType)
  throws InstantiationException
  {
    logger.info("Creating TxMgr implementation for {}", oatsdbType);

    TxMgr txMgr = null;

    try {
      if (oatsdbType == null) {
        final String msg = "Null 'oatsdbType' parameter";
        logger.error(msg);
        throw new ClassNotFoundException(msg);
      }
      
      Class<?> clazz = null;
      Object instance = null;

      switch(oatsdbType) {
      case V0:
        clazz = Class.forName("edu.yu.oats.oatsdb.dbms.v0.TxMgrImpl");
        instance = Enum.valueOf((Class<Enum>)clazz, "Instance");
        txMgr = TxMgr.class.cast(instance);
        break;
      case V0b:
        clazz = Class.forName("edu.yu.oats.oatsdb.dbms.v0b.TxMgrImpl");
        instance = Enum.valueOf((Class<Enum>)clazz, "Instance");
        txMgr = TxMgr.class.cast(instance);
        break;
      case V0c:
        clazz = Class.forName("edu.yu.oats.oatsdb.dbms.v0c.TxMgrImpl");
        instance = Enum.valueOf((Class<Enum>)clazz, "Instance");
        txMgr = TxMgr.class.cast(instance);
        break;
      case V1a:
        clazz = Class.forName("edu.yu.oats.oatsdb.dbms.v1a.TxMgrImpl");
        instance = Enum.valueOf((Class<Enum>)clazz, "Instance");
        txMgr = TxMgr.class.cast(instance);
        break;
      default:
        logger.error("Unknown 'oatsdbType' parameter: {}", oatsdbType);
        throw new ClassNotFoundException
          ("Unknown 'oatsdbType' parameter: "+oatsdbType);
      } // switch
    }   // try
    catch(Exception e) {
      final String msg = "Problem creating instance of "+oatsdbType+" ["+e+"]";
      logger.error(msg);
      throw new InstantiationException(msg); // no version which takes "cause"
    }

    return txMgr;
  }
  
  // =========================================================================
  // ivars
  // =========================================================================
  private final static Logger logger = LogManager.getLogger(OATSDBType.class);
}
