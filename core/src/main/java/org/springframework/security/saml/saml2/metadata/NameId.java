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

package org.springframework.security.saml.saml2.metadata;

import javax.annotation.Nonnull;

public enum NameId {

    UNSPECIFIED("urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified"),
    EMAIL("urn:oasis:names:tc:SAML:1.1:nameid-format:emailAddress"),
    TRANSIENT("urn:oasis:names:tc:SAML:2.0:nameid-format:transient"),
    PERSISTENT("urn:oasis:names:tc:SAML:2.0:nameid-format:persistent"),
    X509_SUBJECT("urn:oasis:names:tc:SAML:1.1:nameid-format:X509SubjectName"),
    WIN_DOMAIN_QUALIFIED("urn:oasis:names:tc:SAML:1.1:nameid-format:WindowsDomainQualifiedName"),
    KERBEROS("urn:oasis:names:tc:SAML:2.0:nameid-format:kerberos"),
    ENTITY("urn:oasis:names:tc:SAML:2.0:nameid-format:entity"),
    ENCRYPTED("urn:oasis:names:tc:SAML:2.0:nameid-format:encrypted");


    private final String urn;

    NameId(@Nonnull String urn) {
        this.urn = urn;
    }


    @Override
    public String toString() {
        return this.urn;
    }

    public static NameId fromUrn(String other) {
        for (NameId name : values()) {
            if (name.urn.equalsIgnoreCase(other)) {
                return name;
            }
        }
        return null;
    }
}
