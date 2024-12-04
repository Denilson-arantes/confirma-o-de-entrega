// Função para lidar com o sucesso ao escanear o QR Code
function onScanSuccess(decodedText, decodedResult) {
  console.log("QR Code escaneado:", decodedText);
  // Exibir o texto escaneado na página
  document.getElementById("output").innerText = Dados do QR Code: ${decodedText};

  // Parar o scanner após capturar o QR Code
  html5QrCode.stop().then(() => {
    console.log("Scanner parado após sucesso!");
  }).catch(err => {
    console.error("Erro ao parar o scanner:", err);
  });
}

// Configurar o scanner do QR Code
const html5QrCode = new Html5Qrcode("reader");
const cameraConfig = { fps: 10, qrbox: 250 };

// Iniciar o scanner com a câmera traseira
html5QrCode.start({ facingMode: "environment" }, cameraConfig, onScanSuccess)
  .catch(err => console.error("Erro ao iniciar o scanner:", err));
