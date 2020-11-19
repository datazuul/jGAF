package com.plealog.jgaf.prefs4j.implem.core.io;

import com.plealog.jgaf.genericapp.ui.starter.EZEnvironmentImplem;
import com.plealog.jgaf.prefs4j.api.DataConnector;
import com.plealog.jgaf.prefs4j.api.DataConnector.TYPE;
import com.plealog.jgaf.prefs4j.api.PropertiesDataConnector;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class BasicPropertiesDataConnectorImplem implements PropertiesDataConnector {
  public BasicPropertiesDataConnectorImplem() {}

  @Override
  public void save(String locator, Properties props) throws IOException {
    FileOutputStream fos;

    fos = new FileOutputStream(new File(locator));
    EZEnvironmentImplem.saveProperties(props, fos, null);
    fos.flush();
    fos.close();
  }

  @Override
  public Properties load(String locator) throws IOException {
    FileInputStream fis;
    fis = new FileInputStream(new File(locator));
    Properties props = new Properties();
    props = EZEnvironmentImplem.loadProperties(fis);
    fis.close();
    return props;
  }

  public TYPE getType() {
    return DataConnector.TYPE.props;
  }

  @Override
  public DataConnector newInstance() {
    return this;
  }

  @Override
  public boolean canRead(String locator) {
    if (locator == null) return false;
    return new File(locator).canRead();
  }

  @Override
  public boolean canWrite(String locator) {
    if (locator == null) return false;
    return new File(locator).canWrite();
  }
}
