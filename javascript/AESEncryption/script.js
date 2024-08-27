const crypto = require('crypto');


const encrypt = (keyString, ivString, plainText) => {
	const algorithm = 'aes-128-cbc';
	const iv = ivString;

	const cipher = crypto.createCipheriv(algorithm, Buffer.from(keyString, 'base64'), Buffer.from(ivString, 'base64'));

	let encryptedData = cipher.update(plainText, 'utf-8', 'base64');
	encryptedData += cipher.final('base64');
	return encryptedData;
};


const plainText = 'Random';
const keyString = 'ECoXAQ7tesDtU4AfrP2wYA==';
const ivString = 'eu8zIWS3wch/XZzRzOFN3Q==';

const encryptedString = encrypt(keyString, ivString, plainText);
console.log(encryptedString);