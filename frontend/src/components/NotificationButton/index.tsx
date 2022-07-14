//apelidei a imagem importada como icon
import icon from '../../assets/img/notification-icon.svg'

//mesma pasta é ./, pasta anterior ../
import './styles.css'

function NotificationButton() {
    return (
        <div className="dsmeta-red-btn">
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton