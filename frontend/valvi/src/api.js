import { setAuthToken, getAuthToken, setUsername, getUsername } from "./api_helper";

const BASE_URL = 'http://localhost:8080';

const getGames = async (filter) => {
  try {
    const url = `${BASE_URL}/videogames`;
    const response = await fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + getAuthToken() || ''
      },
      body: JSON.stringify(filter),
    });

    if (!response.ok) {
      throw new Error('Error en la solicitud: ' + response.statusText);
    }

    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Se produjo un error:', error);
    // Puedes lanzar el error nuevamente si quieres manejarlo en el componente que llama a esta función
    throw error;
  }
};

const getGameById = async (id) => {
  try {
    const url = `${BASE_URL}/videogames/${id}`;
    const response = await fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + getAuthToken() || ''
      },
    });

    if (!response.ok) {
      throw new Error('Error en la solicitud: ' + response.statusText);
    }

    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Se produjo un error:', error);
    // Puedes lanzar el error nuevamente si quieres manejarlo en el componente que llama a esta función
    throw error;
  }
};

const loginUser = async (username, password) => {
  const url = `${BASE_URL}/auth/login`;
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
    setAuthToken(result.token);
    setUsername(result.username);
    return result;
  } catch (error) {
    console.error('Error:', error.message);
  }
}

const registerUser = async (username, password) => {
  const url = `${BASE_URL}/auth/register`;
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

const getGamesByUser = async () => {
  try {
    const url = `${BASE_URL}/ratings/${getUsername()}`;
    const response = await fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + getAuthToken() || ''
      },
    });

    if (!response.ok) {
      throw new Error('Error en la solicitud: ' + response.statusText);
    }

    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Se produjo un error:', error);
    setAuthToken(null);
    // Puedes lanzar el error nuevamente si quieres manejarlo en el componente que llama a esta función
    throw error;
  }
};

const getRatingByUserAndGame = async (gameId) => {
  try {
    const url = `${BASE_URL}/ratings/${gameId}/${getUsername()}`;
    const response = await fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + getAuthToken() || ''
      },
    });

    if (!response.ok) {
      throw new Error('Error en la solicitud: ' + response.statusText);
    }

    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Se produjo un error:', error);
    // Puedes lanzar el error nuevamente si quieres manejarlo en el componente que llama a esta función
    throw error;
  }
};

const upsertRating = async (rating) => {
  const url = `${BASE_URL}/ratings`;
  const bodyData = {...rating, username: getUsername()};

  return fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + getAuthToken() || ''
    },
    body: JSON.stringify(bodyData),
  });
}

const getLastReviews = async (num) => {
  try {
    const url = `${BASE_URL}/reviews/lastReviews/${num}`;
    const response = await fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + getAuthToken() || ''
      },
    });

    if (!response.ok) {
      throw new Error('Error en la solicitud: ' + response.statusText);
    }

    const data = await response.json();
    return data;

  } catch (error) {
    console.error('Se produjo un error:', error);
    // Puedes lanzar el error nuevamente si quieres manejarlo en el componente que llama a esta función
    throw error;
  }
}

const getReviewsByGame = async (gameId) => {
  try {
    const url = `${BASE_URL}/reviews/game/${gameId}`;
    const response = await fetch(url, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + getAuthToken() || ''
      },
    });

    if (!response.ok) {
      throw new Error('Error en la solicitud: ' + response.statusText);
    }

    const data = await response.json();
    return data;

  } catch (error) {
    console.error('Se produjo un error:', error);
    // Puedes lanzar el error nuevamente si quieres manejarlo en el componente que llama a esta función
    throw error;
  }
}

const createReview = async (review) => {
  const url = `${BASE_URL}/reviews`;
  const bodyData = {...review, username: getUsername()};

  return fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + getAuthToken() || ''
    },
    body: JSON.stringify(bodyData),
  });
}

export default {
  loginUser,
  registerUser,
  getGames,
  getGameById,
  getGamesByUser,
  getRatingByUserAndGame,
  upsertRating,
  getLastReviews,
  getReviewsByGame,
  createReview
}