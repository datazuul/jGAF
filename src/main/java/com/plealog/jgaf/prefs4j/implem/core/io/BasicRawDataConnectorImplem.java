package com.plealog.jgaf.prefs4j.implem.core.io;

import com.plealog.jgaf.prefs4j.api.DataConnector;
import com.plealog.jgaf.prefs4j.api.DataConnector.TYPE;
import com.plealog.jgaf.prefs4j.api.RawDataConnector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BasicRawDataConnectorImplem implements RawDataConnector {

  public BasicRawDataConnectorImplem() {}

  @Override
  public void save(String locator, String data) throws IOException {
    PrintWriter writer;
    FileWriter fw;

    fw = new FileWriter(locator);
    writer = new PrintWriter(new BufferedWriter(fw));
    writer.println(data);
    writer.flush();
    fw.close();
  }

  @Override
  public String load(String locator) throws IOException {
    StringBuffer szBuf;
    BufferedReader in = null;
    String line;

    in = new BufferedReader(new FileReader(locator));
    szBuf = new StringBuffer();
    while ((line = in.readLine()) != null) {
      szBuf.append(line);
      szBuf.append("\n");
    }
    in.close();
    return szBuf.toString();
  }

  @Override
  public TYPE getType() {
    return DataConnector.TYPE.raw;
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
