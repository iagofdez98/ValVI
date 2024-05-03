const BASE_URL = 'http://localhost:8080';

const loginUser = async (username, password) => {
  const url = `${BASE_URL}/users/authenticate`;
  const data = {
    username: username,
    password: password
  };

  try {
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    });

    if (!response.ok) {
      throw new Error('Error en la solicitud');
    }

    const result = await response.json();
    return result;
  } catch (error) {
    console.error('Error:', error.message);
  }
}

const registerUser = async (username, password) => {
  const url = `${BASE_URL}/users`;
  const bodyData = {
    username,
    password
  };

  try {
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(bodyData),
    });

    if (!response.ok) {
      throw new Error('Error en la solicitud');
    }

    const data = await response.json();
    console.log('Datos obtenidos:', data);
    return data;
  } catch (error) {
    console.error('Error:', error.message);
  }
}

export default {
  loginUser,
  registerUser
}