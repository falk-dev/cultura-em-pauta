package model.util;

import java.util.regex.Pattern;

public class Email {
  // Padrão regex rigoroso baseado no RFC 5322 (simplificado)
  private static final String REGEX_EMAIL = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";

  private static final Pattern padraoEmail = Pattern.compile(REGEX_EMAIL);

  public static boolean validarEmail(String email) {
    if (email == null || email.trim().isEmpty()) {
      return false;
    }

    String emailLimpo = email.trim();

    // Verificações básicas primeiro
    if (emailLimpo.length() > 254) { // Limite RFC 5321
      return false;
    }

    if (!emailLimpo.contains("@")) {
      return false;
    }

    // Não pode começar ou terminar com @
    if (emailLimpo.startsWith("@") || emailLimpo.endsWith("@")) {
      return false;
    }

    // Não pode ter @ consecutivos
    if (emailLimpo.contains("@@")) {
      return false;
    }

    return padraoEmail.matcher(emailLimpo).matches();
  }
}