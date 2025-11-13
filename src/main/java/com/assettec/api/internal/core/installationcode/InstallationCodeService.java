package com.assettec.api.internal.core.installationcode;

import com.assettec.api.internal.users.ApiUser;
import com.assettec.api.internal.core.installationcode.utilities.InstallationCodeUpdater;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstallationCodeService {

    private InstallationCodeUpdater installationCodeUpdater;

    public InstallationCode getInstallationCode(ApiUser apiUser, String installationCode) {
        return installationCodeUpdater.updateInstallationCode(apiUser, installationCode);
    }
}
