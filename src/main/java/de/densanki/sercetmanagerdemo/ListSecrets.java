package de.densanki.sercetmanagerdemo;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;

public class ListSecrets {

  public static void run() {
    AWSSecretsManager awsSecretsManager = AWSSecretsManagerClientBuilder.standard().withRegion(Constants.DEFAULT_REGION).build();

    ListSecretsRequest listSecretsRequest = new ListSecretsRequest();
    ListSecretsResult listSecretsResult = awsSecretsManager.listSecrets(listSecretsRequest);

    StringBuilder stringBuilder =new StringBuilder();

    for(SecretListEntry secret : listSecretsResult.getSecretList()){
      stringBuilder.append("Secret Name=" + secret.getName() + Constants.NL);
      stringBuilder.append("Secret ARN=" + secret.getARN() + Constants.NL);
      stringBuilder.append("Secret Description=" + secret.getDescription() + Constants.NL);
      stringBuilder.append("Secret KmsKeyId=" + secret.getKmsKeyId() + Constants.NL);
      stringBuilder.append("Secret Versions=" + secret.getSecretVersionsToStages().toString() + Constants.NL);
    }

    System.out.println(stringBuilder.toString());
  }

}
