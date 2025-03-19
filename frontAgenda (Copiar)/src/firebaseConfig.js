import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import { getAnalytics } from "firebase/analytics";

// Configuración de Firebase
const firebaseConfig = {
  apiKey: "AIzaSyDYhZPA58u5cjprEBSfv5fDVA40KLrCxCs",
  authDomain: "autentdiu.firebaseapp.com",
  projectId: "autentdiu",
  storageBucket: "autentdiu.firebasestorage.app",
  messagingSenderId: "711873949843",
  appId: "1:711873949843:web:2f705204c064558c3d1d66",
  measurementId: "G-J99HKXBPE5",
};

// Inicializar Firebase
const app = initializeApp(firebaseConfig);
const auth = getAuth(app); // Aquí definimos 'auth'
const analytics = getAnalytics(app);

export { auth }; // Ahora 'auth' está definido correctamente y se puede exportar
