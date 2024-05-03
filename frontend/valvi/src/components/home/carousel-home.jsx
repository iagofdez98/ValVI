import React from 'react';
import { Carousel } from 'react-bootstrap';

const ImageCarousel = () => {
    return (
        <Carousel>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images.igdb.com/igdb/image/upload/t_original/lqz37tmv2r4lcjaxczwx.webp"
                    alt="First slide"
                    style={{ maxHeight: '12.5rem', objectFit: 'cover' }}
                />
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images.igdb.com/igdb/image/upload/t_original/schai0.webp"
                    alt="Second slide"
                    style={{ maxHeight: '12.5rem', objectFit: 'cover' }}
                />
            </Carousel.Item>
            <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://images.igdb.com/igdb/image/upload/t_original/ityinxmtkakwbokpcwws.webp"
                    alt="Third slide"
                    style={{ maxHeight: '12.5rem', objectFit: 'cover' }}
                />
            </Carousel.Item>
        </Carousel>
    );
};

export default ImageCarousel;
