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

package org.springframework.security.saml.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SamlConfiguration {

    private LocalProviderConfiguration serviceProvider;
    private LocalProviderConfiguration identityProvider;

    public LocalProviderConfiguration getServiceProvider() {
        return serviceProvider;
    }

    public SamlConfiguration setServiceProvider(LocalProviderConfiguration serviceProvider) {
        this.serviceProvider = serviceProvider;
        return this;
    }

    public LocalProviderConfiguration getIdentityProvider() {
        return identityProvider;
    }

    public SamlConfiguration setIdentityProvider(LocalProviderConfiguration identityProvider) {
        this.identityProvider = identityProvider;
        return this;
    }
}
