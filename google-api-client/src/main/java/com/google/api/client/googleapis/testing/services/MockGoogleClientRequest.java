/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.api.client.googleapis.testing.services;

import com.google.api.client.googleapis.services.AbstractGoogleClient;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.subscriptions.NotificationCallback;
import com.google.api.client.googleapis.subscriptions.TypedNotificationCallback;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.UriTemplate;

/**
 * Thread-safe mock Google request.
 *
 * @param <T> type of the response
 * @since 1.12
 * @author Yaniv Inbar
 */
public class MockGoogleClientRequest<T> extends AbstractGoogleClientRequest<T> {

  /**
   * @param client Google client
   * @param method HTTP Method
   * @param uriTemplate URI template for the path relative to the base URL. If it starts with a "/"
   *        the base path from the base URL will be stripped out. The URI template can also be a
   *        full URL. URI template expansion is done using
   *        {@link UriTemplate#expand(String, String, Object, boolean)}
   * @param content HTTP content or {@code null} for none
   * @param responseClass response class to parse into
   */
  public MockGoogleClientRequest(AbstractGoogleClient client, String method, String uriTemplate,
      HttpContent content, Class<T> responseClass) {
    super(client, method, uriTemplate, content, responseClass);
  }

  @Override
  public MockGoogleClientRequest<T> setDisableGZipContent(boolean disableGZipContent) {
    return (MockGoogleClientRequest<T>) super.setDisableGZipContent(disableGZipContent);
  }

  @Override
  public MockGoogleClientRequest<T> setRequestHeaders(HttpHeaders headers) {
    return (MockGoogleClientRequest<T>) super.setRequestHeaders(headers);
  }

  /**
   * @since 1.13
   */
  @Override
  public AbstractGoogleClientRequest<T> setNotificationClientToken(String notificationClientToken) {
    return super.setNotificationClientToken(notificationClientToken);
  }

  /**
   * @since 1.13
   */
  @Override
  public MockGoogleClientRequest<T> subscribeUnparsed(
      String notificationDeliveryMethod, NotificationCallback notificationCallback) {
    return (MockGoogleClientRequest<T>) super.subscribeUnparsed(
        notificationDeliveryMethod, notificationCallback);
  }

  /**
   * @since 1.13
   */
  @Override
  public MockGoogleClientRequest<T> subscribe(
      String notificationDeliveryMethod, TypedNotificationCallback<T> typedNotificationCallback) {
    return (MockGoogleClientRequest<T>) super.subscribe(
        notificationDeliveryMethod, typedNotificationCallback);
  }
}
