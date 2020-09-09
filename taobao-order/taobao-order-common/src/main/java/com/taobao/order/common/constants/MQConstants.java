package com.taobao.order.common.constants;


/**
 * @author Lawrence Li
 * @date 2020/9/9 3:34 PM
 */
public class MQConstants {

    public static final class Exchange {
        /**
         * hotel service exchange topic
         */
        public static final String HOTEL_EXCHANGE_TOPIC = "hotel-order-service.topic.exchange";
        /**
         * hotel service exchange direct
         */
        public static final String HOTEL_EXCHANGE_DIRECT = "hotel-order-service.direct.exchange";

        /**
         * cancel order - Dead letter exchange
         */
        public static final String CANCEL_ORDER_DLX_DIRECT = "hotel-order-service.cancel-order.dlx.exchange";
    }

    public static final class RoutingKey {

        /**
         * cancel order routing-key
         */
        public static final String ORDER_CANCEL_DLX_KEY = "order.cancel.dlx";
        /**
         * create order routing-key
         */
        public static final String ORDER_CREATE_KEY = "order.create";
        /**
         * save order routing-key
         */
        public static final String ORDER_SAVE_KEY = "order.save";

        /**
         * confirm order routing-key
         */
        public static final String ORDER_CONFIRM_KEY = "hotel.order.confirm";

        /**
         * make payment routing-key
         */
        public static final String ORDER_MAKE_PAYMENT_KEY = "hotel.make.payment";

        /**
         * make payment response to adapter
         */
        public static final String MAKE_PAYMENT_RESPONSE_KEY = "hotel.make.payment.response";
        /**
         * cancel order request routing-key
         */
        public static final String BOOKING_CANCEL_REQUEST_KEY = "hotel.order.cancel";
        /**
         * cancel booking routing-key
         */
        public static final String BOOKING_CANCEL_KEY = "opera.booking.cancel";
        /**
         * payment notify result routing key
         */
        public static final String PAYMENT_NOTIFY_RESULT_KEY = "payment.notify.result";
        /**
         * order refund routing key
         */
        public static final String ORDER_REFUND_KEY = "order.refund";
    }

    public static final class Queue{

        public static final String HOTEL_ORDER_CANCEL_DLX = "hotel.order.cancel.dlx.queue";
        /**
         * hotel service create order queue
         */
        public static final String HOTEL_ORDER_CREATE = "hotel.order.create.queue";

        /**
         * hotel service save order queue
         */
        public static final String HOTEL_ORDER_SAVE = "hotel.order.save.queue";

        /**
         * hotel service cancel order queue
         */
        public static final String HOTEL_ORDER_CANCEL = "hotel.order.cancel.queue";

        /**
         * hotel service confirm order queue
         */
        public static final String HOTEL_ORDER_CONFIRM = "hotel.order.confirm.queue";

        /**
         * hotel service make payment queue
         */
        public static final String HOTEL_ORDER_MAKE_PAYMENT= "hotel.order.make.payment.queue";


        /**
         * cancel booking in Opera queue
         */
        public static final String OPERA_BOOKING_CANCEL = "opera.booking.cancel.queue";

        /**
         * payment notify result from pmw
         */
        public static final String PAYMENT_NOTIFY_RESULT = "payment.notify.result.queue";

        /**
         * order refund queue
         */
        public static final String ORDER_REFUND_QUEUE = "order.refund.queue";
    }

}