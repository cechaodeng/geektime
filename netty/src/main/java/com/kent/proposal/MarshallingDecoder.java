package com.kent.proposal;

import io.netty.buffer.ByteBuf;

import javax.xml.bind.Unmarshaller;

public class MarshallingDecoder {
//    private final Unmarshaller unmarshaller;

    public Object decode(ByteBuf in ) throws  Exception {
        /*int objectSize = in.readInt();
        ByteBuf buf = in.slice(in.readerIndex(), objectSize);
        ByteInput input = new ChannelBufferByteInput(buf);
        try {
            unmarshaller.start(input);
            Object obj = unmarshaller.readObject();
            unmarshaller.finish();
            in.readerIndex(in.readerIndex() + objectSize);
            return obj;
        }finally {
            unmarshaller.close();
        }*/
        return null;
    }
}
