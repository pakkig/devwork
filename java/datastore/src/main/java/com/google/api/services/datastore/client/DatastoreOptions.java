/*
 * Copyright 2013 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.api.services.datastore.client;

import com.google.api.client.auth.oauth2.Credential;

/**
 * A mutable object containing settings for the datastore.
 *
 * <p>Example for connecting to a datastore:</p>
 *
 * <pre>
 * DatastoreOptions options = new DatastoreOptions()
 *     .dataset("my-dataset-id"),
 *     .credential(DatastoreHelper.getGceCredential());
 * DatastoreFactory.get().create(options);
 * </pre>
 *
 * <p>
 * The options should be passed to {@link DatastoreFactory#create}.
 * </p>
 *
 */
public class DatastoreOptions {
  private final String dataset;
  private final String host;
  private static final String DEFAULT_HOST = "https://www.googleapis.com";

  private final Credential credential;
  public static final String SCOPE = "https://www.googleapis.com/auth/datastore" +
      " https://www.googleapis.com/auth/userinfo.email";

  DatastoreOptions(String dataset, String host, Credential credential) {
    this.dataset = dataset;
    this.host = host != null ? host : DEFAULT_HOST;
    this.credential = credential;
  }

  /**
   * Builder for {@link DatastoreOptions}.
   */
  public static class Builder {
    private String dataset;
    private String host;
    private Credential credential;

    public Builder() { }

    public Builder(DatastoreOptions options) {
      this.dataset = options.dataset;
      this.host = options.host;
      this.credential = options.credential;
    }

    public DatastoreOptions build() {
      return new DatastoreOptions(dataset, host, credential);
    }

    /**
     * Sets the dataset used to access the datastore.
     */
    public Builder dataset(String newDataset) {
      dataset = newDataset;
      return this;
    }

    /**
     * Sets the host used to access the datastore.
     */
    public Builder host(String newHost) {
      host = newHost;
      return this;
    }

    /**
     * Sets the Google APIs credentials used to access the API.
     */
    public Builder credential(Credential newCredential) {
      credential = newCredential;
      return this;
    }
  }

  // === getters ===

  public String getDataset() {
    return dataset;
  }

  public String getHost() {
    return host;
  }

  public Credential getCredential() {
    return credential;
  }

}