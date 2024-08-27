const crypto = require('crypto');


const encrypt = (publicKeyString, plainText) => {
	const publicKey = crypto.createPublicKey({ key: Buffer.from(publicKeyString, 'base64'), format: 'der', type: 'spki' });

	const encryptedData = crypto.publicEncrypt({
  		key: publicKey,
	  	padding: crypto.constants.RSA_PKCS1_PADDING
	}, Buffer.from(plainText, 'utf8'));

	return encryptedData.toString('base64');
};


const plainText = 'hello';
const publicKeyString = 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA112RAFM014b1EZyomsXS1RyrkW44Y4Hxa8ZwVF0y0mjatny13KXvGcmL43kd1NFMA7WoNRtQDIubMPd/OE8EMCJl+/hFCMgLK9hr8D39uCihF4KApRVXtX+5EdR0fk6j6WEcRgZxZlaISSN8r+tS0qRMF3za5E8j1fxqisOsEa+P4GfBNMI14z7gw3W5DyPhijc5b423/N1WzdbpRV15Bdu5X9iK/WstMxPfgPZt6JoOHq0WUge9Brs2Xev8/cFOZOs1zxhqQmoxrqiV2qLDkK1n+zz3qVcQFmIgYicyc14uwMigmL70zwsKF7AMFlkVkrIYKaWEOjddI66YmDmaFQIDAQAB';

const encryptedString = encrypt(publicKeyString, plainText);
console.log(encryptedString);