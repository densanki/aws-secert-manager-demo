package de.densanki.sercetmanagerdemo;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;

public class RetriveSecret {

  public static void run() {
    AWSSecretsManager awsSecretsManager = AWSSecretsManagerClientBuilder.standard().withRegion(Constants.DEFAULT_REGION).build();

    GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest();
    getSecretValueRequest.setSecretId(Constants.SECRET_NAME);
    GetSecretValueResult getSecretValueResult = awsSecretsManager.getSecretValue(getSecretValueRequest);

    StringBuilder stringBuilder =new StringBuilder();
    stringBuilder.append("Secret Name=" + getSecretValueResult.getName() + Constants.NL);
    stringBuilder.append("Secret ARN=" + getSecretValueResult.getARN() + Constants.NL);
    stringBuilder.append("Secret Value=" + getSecretValueResult.getSecretString() + Constants.NL);

    System.out.println(stringBuilder.toString());
  }

}
