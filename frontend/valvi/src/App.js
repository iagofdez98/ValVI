import React, { useState, useEffect } from 'react';
import './App.css';
import LoadingPage from './components/auth/auth';
import Home from './components/home/home';
import Header from './components/app-header';
import Footer from './components/app-footer';

const App = () => {
  const [isLogged, setIsLogged] = useState(false);

  return (<div className='bg-dark text-light'>
    <Header/>
    {/* <LoadingPage onLogin={setIsLogged}/> */}
    <Home/>
    <Footer/>
    </div>
  );
};

export default App;
