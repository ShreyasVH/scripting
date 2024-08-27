const crypto = require('crypto');

const decrypt = (keyString, ivString, encryptedText) => {
    const algorithm = 'aes-128-cbc';
    
    // Convert key and IV to buffers
    const key = Buffer.from(keyString, 'base64');
    const iv = Buffer.from(ivString, 'base64');

    const decipher = crypto.createDecipheriv(algorithm, key, iv);

    let decryptedData = decipher.update(Buffer.from(encryptedText, 'base64').toString('hex'), 'hex', 'utf-8');
    decryptedData += decipher.final('utf-8');
    
    return decryptedData;
};

const encryptedText = '4yPCHuwVgaUfl8ZeKqWWTA==';
const keyString = 'ECoXAQ7tesDtU4AfrP2wYA==';
const ivString = 'eu8zIWS3wch/XZzRzOFN3Q==';

const decryptedString = decrypt(keyString, ivString, encryptedText);
console.log(decryptedString);