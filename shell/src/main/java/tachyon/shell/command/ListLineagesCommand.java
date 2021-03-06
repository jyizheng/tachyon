/*
 * Licensed to the University of California, Berkeley under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package tachyon.shell.command;

import java.io.IOException;
import java.util.List;

import tachyon.client.file.TachyonFileSystem;
import tachyon.client.lineage.TachyonLineage;
import tachyon.conf.TachyonConf;
import tachyon.thrift.LineageInfo;

/**
 * TODO(yupeng): add javadoc
 */
public final class ListLineagesCommand extends AbstractTfsShellCommand {

  public ListLineagesCommand(TachyonConf conf, TachyonFileSystem tfs) {
    super(conf, tfs);
  }

  @Override
  public String getCommandName() {
    return "listLineages";
  }

  @Override
  protected int getNumOfArgs() {
    return 0;
  }

  @Override
  public void run(String... args) throws IOException {
    TachyonLineage tl = TachyonLineage.get();
    List<LineageInfo> infos = tl.getLineageInfoList();
    for (LineageInfo info : infos) {
      System.out.println(info);
    }
  }
}
