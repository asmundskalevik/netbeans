/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.debugger.jpda.truffle.frames.models;

import java.util.Collections;
import java.util.List;

import org.netbeans.modules.debugger.jpda.truffle.access.CurrentPCInfo;
import org.netbeans.modules.debugger.jpda.truffle.access.TruffleAccess;
import org.netbeans.modules.debugger.jpda.truffle.frames.TruffleStackFrame;
import org.netbeans.modules.debugger.jpda.truffle.options.TruffleOptions;
import org.netbeans.modules.debugger.jpda.ui.debugging.DebuggingViewSupportImpl;
import org.netbeans.modules.debugger.jpda.ui.debugging.JPDADVThread;
import org.netbeans.spi.debugger.ContextProvider;
import org.netbeans.spi.debugger.ui.DebuggingView;
import org.netbeans.spi.debugger.ui.DebuggingView.DVFrame;

/**
 *
 * @author Martin Entlicher
 */
@DebuggingView.DVSupport.Registration(path="netbeans-JPDASession")
public class DebuggingViewTruffleSupport extends DebuggingViewSupportImpl {

    public DebuggingViewTruffleSupport(ContextProvider lookupProvider) {
        super(lookupProvider);
    }

    @Override
    protected int getFrameCount(JPDADVThread thread) {
        CurrentPCInfo currentPCInfo = TruffleAccess.getCurrentPCInfo(thread.getKey());
        if (currentPCInfo != null) {
            return getFrames(thread, 0, Integer.MAX_VALUE).size();
        } else {
            return super.getFrameCount(thread);
        }
    }

    @Override
    protected List<DVFrame> getFrames(JPDADVThread thread, int from, int to) {
        List<DVFrame> frames = super.getFrames(thread, 0, Integer.MAX_VALUE);
        CurrentPCInfo currentPCInfo = TruffleAccess.getCurrentPCInfo(thread.getKey());
        if (currentPCInfo != null) {
            boolean showInternalFrames = TruffleOptions.isLanguageDeveloperMode();
            TruffleStackFrame[] stackFrames = currentPCInfo.getStack().getStackFrames(showInternalFrames);
            frames = DebuggingTruffleTreeModel.filterAndAppend(thread, frames, stackFrames, currentPCInfo.getTopFrame());
        }
        if (from >= frames.size()) {
            return Collections.emptyList();
        }
        to = Math.min(to, frames.size());
        return frames.subList(from, to);
    }

    @Override
    public String getDisplayName(DVFrame frame) {
        if (frame instanceof TruffleDVFrame) {
            return ((TruffleDVFrame) frame).getTruffleFrame().getDisplayName();
        } else {
            return super.getDisplayName(frame);
        }
    }

}
