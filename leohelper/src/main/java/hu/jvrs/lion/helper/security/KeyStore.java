package hu.jvrs.lion.helper.security;

public class KeyStore {
	
	//TODO keystore, certificate, ssl, base64
	
//	 RendszerParameter keystoreFileParam = rendszerParameterDao.getRendszerParameterByAzonosito(JEConstants.RENDSZER_PARAMETER_QRSIGNATURE_KEYSTORE_FILE);
//     RendszerParameter keystorePassParam = rendszerParameterDao.getRendszerParameterByAzonosito(JEConstants.RENDSZER_PARAMETER_QRSIGNATURE_KEYSTORE_PASSWORD);
//     if (keystoreFileParam != null && keystorePassParam!=null) {
//         String keystoreFile = keystoreFileParam.getErtek();
//         String keystorePass = keystorePassParam.getErtek();
	
//	KeyStore ks = KeyStore.getInstance(KEYSTORE_INSTANCE);
//    ks.load(new FileInputStream(keystoreFile), keystorePass.toCharArray());
//    
//    for (PublikusKulcs kulcs : kulcsok) {
//        PublikusKulcsLeiroTipus publikusKulcsLeiroTipus = new PublikusKulcsLeiroTipus();
//        publikusKulcsLeiroTipus.setAlias(kulcs.getAlias());
//        publikusKulcsLeiroTipus.setErvenyessegKezdete(DateTimeXmlAdapter.asXMLGregorianCalendar(kulcs.getErvenyessegKezdete()));
//        publikusKulcsLeiroTipus.setErvenyessegVege(DateTimeXmlAdapter.asXMLGregorianCalendar(kulcs.getErvenyessegVege()));
//        publikusKulcsLeiroTipus.setKulcsFelhasznalasCelTipus(kulcs.getKulcsFelhasznalasCelTipus());
//        publikusKulcsLeiroTipus.setVerzioSzam(kulcs.getVerzioszam().intValue());
//
//        String keyAlias = kulcs.getAlias();
//        java.security.cert.Certificate cert = ks.getCertificate(keyAlias);
//        PublicKey key = cert.getPublicKey();
//
//        KeyFactory fact = KeyFactory.getInstance("RSA");
//        X509EncodedKeySpec spec = fact.getKeySpec(key,
//                X509EncodedKeySpec.class);
//        String keyString =  Base64.encodeBase64String(spec.getEncoded());
//
//        publikusKulcsLeiroTipus.setPEMPublikusKulcs(keyString);
//        valasz.getPublikusKulcsLeiro().add(publikusKulcsLeiroTipus);
//        log.info("Kulcs a listahoz hozzaadva: " + keyAlias);
//    }

}
