/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.hbtop.screen.top;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.apache.hadoop.hbase.classification.InterfaceAudience;
import org.apache.hadoop.hbase.hbtop.RecordFilter;
import org.apache.hadoop.hbase.hbtop.screen.ScreenView;

/**
 * The presentation logic for the filter display mode.
 */
@InterfaceAudience.Private
public class FilterDisplayModeScreenPresenter {

  private final FilterDisplayModeScreenView filterDisplayModeScreenView;
  private final List<RecordFilter> filters;
  private final ScreenView nextScreenView;

  public FilterDisplayModeScreenPresenter(FilterDisplayModeScreenView filterDisplayModeScreenView,
    List<RecordFilter> filters, ScreenView nextScreenView) {
    this.filterDisplayModeScreenView = Objects.requireNonNull(filterDisplayModeScreenView);
    this.filters = Collections.unmodifiableList(new ArrayList<>(Objects.requireNonNull(filters)));
    this.nextScreenView = Objects.requireNonNull(nextScreenView);
  }

  public void init() {
    filterDisplayModeScreenView.showFilters(filters);
    filterDisplayModeScreenView.refreshTerminal();
  }

  public ScreenView returnToNextScreen() {
    return nextScreenView;
  }
}