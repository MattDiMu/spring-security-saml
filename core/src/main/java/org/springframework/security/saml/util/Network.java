/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.springframework.security.saml.util;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class Network {

    public static Network getInstance() {
        return instance;
    }

    protected static Network instance = new Network();

    public ClientHttpRequestFactory createRequestFactory(boolean skipSslValidation) {
        return createRequestFactory(getClientBuilder(skipSslValidation));
    }

    protected ClientHttpRequestFactory createRequestFactory(HttpClientBuilder builder) {
        return new HttpComponentsClientHttpRequestFactory(builder.build());
    }

    protected HttpClientBuilder getClientBuilder(boolean skipSslValidation) {
        HttpClientBuilder builder = HttpClients.custom()
            .useSystemProperties()
            .setRedirectStrategy(new DefaultRedirectStrategy());
        if (skipSslValidation) {
            builder.setSslcontext(getNonValidatingSslContext());
        }
        builder.setConnectionReuseStrategy(NoConnectionReuseStrategy.INSTANCE);
        return builder;
    }

    protected SSLContext getNonValidatingSslContext() {
        try {
            return new SSLContextBuilder().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        }
    }
}
