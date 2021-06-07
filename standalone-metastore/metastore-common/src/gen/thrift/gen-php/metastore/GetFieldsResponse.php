<?php
namespace metastore;

/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
use Thrift\Base\TBase;
use Thrift\Type\TType;
use Thrift\Type\TMessageType;
use Thrift\Exception\TException;
use Thrift\Exception\TProtocolException;
use Thrift\Protocol\TProtocol;
use Thrift\Protocol\TBinaryProtocolAccelerated;
use Thrift\Exception\TApplicationException;

class GetFieldsResponse
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'fields',
            'isRequired' => true,
            'type' => TType::LST,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\metastore\FieldSchema',
                ),
        ),
    );

    /**
     * @var \metastore\FieldSchema[]
     */
    public $fields = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['fields'])) {
                $this->fields = $vals['fields'];
            }
        }
    }

    public function getName()
    {
        return 'GetFieldsResponse';
    }


    public function read($input)
    {
        $xfer = 0;
        $fname = null;
        $ftype = 0;
        $fid = 0;
        $xfer += $input->readStructBegin($fname);
        while (true) {
            $xfer += $input->readFieldBegin($fname, $ftype, $fid);
            if ($ftype == TType::STOP) {
                break;
            }
            switch ($fid) {
                case 1:
                    if ($ftype == TType::LST) {
                        $this->fields = array();
                        $_size1145 = 0;
                        $_etype1148 = 0;
                        $xfer += $input->readListBegin($_etype1148, $_size1145);
                        for ($_i1149 = 0; $_i1149 < $_size1145; ++$_i1149) {
                            $elem1150 = null;
                            $elem1150 = new \metastore\FieldSchema();
                            $xfer += $elem1150->read($input);
                            $this->fields []= $elem1150;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                default:
                    $xfer += $input->skip($ftype);
                    break;
            }
            $xfer += $input->readFieldEnd();
        }
        $xfer += $input->readStructEnd();
        return $xfer;
    }

    public function write($output)
    {
        $xfer = 0;
        $xfer += $output->writeStructBegin('GetFieldsResponse');
        if ($this->fields !== null) {
            if (!is_array($this->fields)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('fields', TType::LST, 1);
            $output->writeListBegin(TType::STRUCT, count($this->fields));
            foreach ($this->fields as $iter1151) {
                $xfer += $iter1151->write($output);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
